package fitrecommend.fitquest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fitrecommend.fitquest.domain.*;
import fitrecommend.fitquest.repository.*;
import jakarta.persistence.EntityManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Transactional
public class GymReportApiController {
    private final GymReportJPARepository gymReportJPARepository;

    private final GymJPARepository gymJPARepository;

    private final GymRepository gymRepository;
    private final MemberRepository memberRepository;

    private final GymReportRepository gymReportRepository;

    private final ExerciseJPARepository exerciseJPARepository;

//    @GetMapping("/gym/progress/{memberId}") // 헬스 운동 진행여부 리턴.
//    public ResponseEntity<GymProgressResponseDto> getGymProgress(@PathVariable Long memberId){
//        Member member = memberRepository.findOne(memberId);
//        List<GymReport> gymReports = gymReportJPARepository.findByMember(member);
//        GymProgressResponseDto gymProgressResponseDto = new GymProgressResponseDto();
//        gymProgressResponseDto.setProgress(Progress.COMPLETE);
//        if(gymReports == null) {
//            return ResponseEntity.ok(gymProgressResponseDto);
//        }
//        for(GymReport gymreport : gymReports) {
//            if (gymreport.getProgress() == Progress.READY) {
//                gymProgressResponseDto.setProgress(Progress.READY);
//                return ResponseEntity.ok(gymProgressResponseDto);
//            } else if (gymreport.getProgress() == Progress.INPROGRESS) {
//                gymProgressResponseDto.setProgress(Progress.INPROGRESS);
//                return ResponseEntity.ok(gymProgressResponseDto);
//            }
//        }
//        return ResponseEntity.ok(gymProgressResponseDto);
//    }

    @GetMapping("/gym/progress/{memberId}")
    public ResponseEntity<GymProgressResponseDto> getGymProgress(@PathVariable Long memberId) {
        Member member = memberRepository.findOne(memberId);
        List<GymReport> gymReports = gymReportJPARepository.findByMember(member);

        GymProgressResponseDto gymProgressResponseDto = new GymProgressResponseDto();

        if (gymReports == null || gymReports.isEmpty()) {
            gymProgressResponseDto.setNextApi("recommend");
            return ResponseEntity.ok(gymProgressResponseDto);
        }
        if (gymReports.get(gymReports.size() - 1).getProgress() == Progress.READY) {
            gymProgressResponseDto.setProgress(Progress.READY);
            gymProgressResponseDto.setNextApi("report");
            return ResponseEntity.ok(gymProgressResponseDto);
        } else if (gymReports.get(gymReports.size() - 1).getProgress() == Progress.INPROGRESS) {
            gymProgressResponseDto.setProgress(Progress.INPROGRESS);
            gymProgressResponseDto.setNextApi("report");
            return ResponseEntity.ok(gymProgressResponseDto);
        }
        else {
            gymProgressResponseDto.setProgress(Progress.COMPLETE);
            LocalDateTime endtime = gymReports.get(gymReports.size() - 1).getEndtime();
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(endtime, now);
            long hoursSinceEnd = duration.toHours();
            if (hoursSinceEnd < 12) {
                gymProgressResponseDto.setNextApi("report");
            } else {
                gymProgressResponseDto.setNextApi("recommend");
            }
            return ResponseEntity.ok(gymProgressResponseDto);
        }
    }

    // 플러터입장
    // 1. nextapi의 값을 확인하고 어떠한 api를 호출할지 결정합니다.
    // 2. Progress의 상태를 확인하고 어떤 화면으로 넘어갈지 결정합니다.
    // report - 보고서를 조회하고 recommend - 운동을 추천해주세요
    // COMPLETE, report - 운동 완료 페이지 이동, 운동보고서 api 호출
    // COMPLETE, recommend - 운동 전 페이지 이동, 운동추천 api호출
    // INPROGRESS, report - 운동 중 페이지 이동, 운동보고서 api호출
    // READY, report - 운동 전 페이지 이동, 운동보고서 api호출
    // NULL, recommend - 운동 전 페이지 이동, 운동 추천 api호출

//    @GetMapping("/gym/calender/{memberId}") // 캘린더에서 운동보고서를 조회할떄 사용하면 됌. 아직 미완성
//    public ResponseEntity<Progress> getGymReports(@PathVariable Long memberId){
//        Member member = memberRepository.findOne(memberId);
//
//        List<GymReport> gymReports = gymReportJPARepository.findByMember(member); // 그 회원에 해당하는 보고서 전체를 조회한다.
//
//
//    }

    /**
     * AI와 통신해야함
     * */

    @GetMapping("/gym/report/recommend/{memberId}")
    public ResponseEntity<GymRecommendResponseDtos> GymReportRecommend(@PathVariable Long memberId) throws JsonProcessingException {

        Member member = memberRepository.findOne(memberId);
        List<GymReport> gymReports = gymReportRepository.findByToday(member.getToday());

        FlaskRecommendRequestDto requestDto = new FlaskRecommendRequestDto();
        GymReport gymReport;
        if(gymReports.size() != 0) {
            gymReport = gymReports.get(gymReports.size() - 1); //이부분이 문제가 될수 있음 위에 gymReport를 새로만들었는데 쳐넣어버림
            for(Exercise exercise : gymReport.getExercises()) {
                RecentExerciseDto recentExerciseDto = new RecentExerciseDto();
                recentExerciseDto.setExerciseId(exercise.getId());
                recentExerciseDto.setSatisfaction(exercise.getSatisfaction());
                requestDto.getRecentExerciseDtos().add(recentExerciseDto);
            }
        }
        else{
            RecentExerciseDto recentExerciseDto = new RecentExerciseDto();
            recentExerciseDto.setSatisfaction(0);
            recentExerciseDto.setExerciseId(null);
            requestDto.getRecentExerciseDtos().add(recentExerciseDto);
        }

        requestDto.setMemberId(memberId);
        requestDto.setToday(member.getToday());

        requestDto.setGoal1(member.getSurvey().getGoal1());
        requestDto.setGoal2(member.getSurvey().getGoal2());
//        for(Exercise exercise : gymReport.getExercises()) {
//            RecentExerciseDto recentExerciseDto = new RecentExerciseDto();
//            recentExerciseDto.setExerciseId(exercise.getId());
//            recentExerciseDto.setSatisfaction(exercise.getSatisfaction());
//            requestDto.getRecentExerciseDtos().add(recentExerciseDto);
//        }


        // JSON 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(requestDto);

        // HTTP 요청 보내기
        String url = "http://13.238.5.151:5000/api/v1/ai/gym/recommend";  // 플라스크 API의 엔드포인트 URL
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FlaskRecommendResponseDto> responseEntity = restTemplate.postForEntity(url, requestEntity, FlaskRecommendResponseDto.class);


        // 필요한 처리가 딱히 있는지 모르겠다. 일단 잘 전달되고 전달받는다는 생각으로 로직을 구성한다.
//        // 응답 처리
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            String response = responseEntity.getBody();
//            // 플라스크에서 반환한 응답 처리
//        } else {
//            // 에러 처리
//        }

        GymReport newGymReport = new GymReport();
        newGymReport.setMember(member);
        member.getGymReports().add(newGymReport);
        GymRecommendResponseDtos gymRecommendResponseDtos = new GymRecommendResponseDtos();
        List<Long> gymIds = responseEntity.getBody().getGymId();
        for (Long gymId : gymIds) {
            Gym gym = gymRepository.findOne(gymId);
            Exercise exercise = new Exercise();
            exercise.setGym(gym);
            exercise.setGymReport(newGymReport);
            exercise.setComplete(Complete.NO);
            exercise.setTotalKcal(0D);
            newGymReport.getExercises().add(exercise);
            GymRecommendResponseDto gymRecommendResponseDto = new GymRecommendResponseDto();  // 이 부분도 추가되어야 합니다.
            gymRecommendResponseDto.setGymId(gymId);
            gymRecommendResponseDto.setName(gym.getName());
            gymRecommendResponseDto.setType(gym.getType());
            gymRecommendResponseDtos.getGymRecommendResponseDtos().add(gymRecommendResponseDto);
            exerciseJPARepository.save(exercise);
        }

        gymReportJPARepository.save(newGymReport);
        memberRepository.save(member);

        return ResponseEntity.ok(gymRecommendResponseDtos);
    }

    @PostMapping("/gym/report/save")
    public ResponseEntity<GymSaveResponseDto> gymReportSave(@RequestBody GymSaveRequestDto gymSaveRequestDto){
        Member member = memberRepository.findOne(gymSaveRequestDto.getMemberId());
        List<GymReport> gymAllReports = gymReportJPARepository.findByMember(member);
        GymReport gymReport = gymAllReports.get(gymAllReports.size()-1);
        for (Exercise exercise : gymReport.getExercises()) {
            exercise.setGymReport(null); // 연결된 GymReport를 끊어줍니다.
            exercise.setGym(null);
            exerciseJPARepository.delete(exercise);

        }
        gymReport.getExercises().clear(); // 마지막으로 조회한 운동보고서에 AI로부터 저장한 운동내역을 다 삭제해버림.
        GymSaveResponseDto gymSaveResponseDto = new GymSaveResponseDto();
        gymReport.setStarttime(gymSaveRequestDto.getStartTime());
        gymReport.setMember(member);
        for(Long id : gymSaveRequestDto.getGymId()){
            Optional<Gym> gymOptional = gymJPARepository.findById(id);
            if(gymOptional.isPresent()) {
                Gym gym = gymOptional.get();
                Exercise exercise = new Exercise();
                exercise.setGym(gym);
                exercise.setGymReport(gymReport);
                exercise.setComplete(Complete.NO);
                exercise.setTotalKcal(0D);
                exerciseJPARepository.save(exercise);
                gymReport.getExercises().add(exercise);
            }
        }
        gymReport.setProgress(Progress.INPROGRESS);
        gymReportJPARepository.save(gymReport);
        gymSaveResponseDto.setState("Success");
        return ResponseEntity.ok(gymSaveResponseDto);
    }

    @GetMapping("/gym/report/{memberId}")
    public ResponseEntity<GymReportResponseDtos> gymReport(@PathVariable Long memberId){
        Member member = memberRepository.findOne(memberId);
        List<GymReport> gymAllReports = gymReportJPARepository.findByMember(member);
        GymReport gymReport = gymAllReports.get(gymAllReports.size()-1);
        GymReportResponseDtos gymReportResponseDtos = new GymReportResponseDtos();
        for(Exercise exercise : gymReport.getExercises()){
            GymReportResponseDto gymReportResponseDto = new GymReportResponseDto();
            gymReportResponseDto.setGymId(exercise.getGym().getId());
            gymReportResponseDto.setGymName(exercise.getGym().getName());
            gymReportResponseDto.setGymType(exercise.getGym().getUrl());
            gymReportResponseDto.setGymInformation(exercise.getGym().getInformation());
            gymReportResponseDtos.gyms.add(gymReportResponseDto);
        }
        return ResponseEntity.ok(gymReportResponseDtos);
    }

    @PostMapping("gym/report/complete")
    public ResponseEntity<GymReportCompleteResponseDto> gymReportComplete(@RequestBody GymReportCompleteRequestDto gymReportCompleteRequestDto){
        Member member = memberRepository.findOne(gymReportCompleteRequestDto.getMemberId());
        GymReportCompleteResponseDto gymReportCompleteResponseDto = new GymReportCompleteResponseDto();
        List<GymReport> gymReports = gymReportJPARepository.findByMember(member);
        GymReport gymReport = gymReports.get(gymReports.size()-1);
        for(Exercise exercise : gymReport.getExercises()){
            GymKcalDto gymKcalDto = new GymKcalDto();
            gymKcalDto.setGymTotalKcal(exercise.getTotalKcal());
            gymKcalDto.setGymId(exercise.getGym().getId());
            gymReportCompleteResponseDto.getGymKcalDtos().add(gymKcalDto);
        }
        gymReport.setStarttime(gymReportCompleteRequestDto.getEndTime());
        gymReport.setDuration(gymReportCompleteRequestDto.getDuration());
        gymReport.setReportKcal(gymReport.getReportKcal());
        gymReportCompleteResponseDto.setTotalGymKcal(gymReport.getReportKcal());
        gymReport.setProgress(Progress.COMPLETE);
        if(member.getToday() == Today.CHEST){
            gymReport.setToday(Today.CHEST);
            member.setToday(Today.BACK);
        }else if(member.getToday() == Today.BACK){
            gymReport.setToday(Today.BACK);
            member.setToday(Today.LEG);
        }else{
            gymReport.setToday(Today.LEG);
            member.setToday(Today.CHEST);
        }
        memberRepository.save(member);
        gymReportJPARepository.save(gymReport);
        return ResponseEntity.ok(gymReportCompleteResponseDto);
    }

    @Data
    public static class GymProgressResponseDto{
        private Progress progress;
        private String nextApi;
    }



    @Data
    public static class GymSaveRequestDto{ // 운동을 저장하고 어떤값을 반환해줘야할까?
        private Long memberId;
        private List<Long> gymId; // 운동 id값을 리스트로 받는다.
        private LocalDateTime startTime;
    }
    @Data
    public static class GymSaveResponseDto{ // 운동을 저장하고 어떤값을 반환해줘야할까?
        private String state;
    }


    @Data
    public static class GymRecommendResponseDtos{
        private List<GymRecommendResponseDto> gymRecommendResponseDtos = new ArrayList<>();
    }

    @Data
    public static class GymRecommendResponseDto{
        private Long gymId;
        private GymType type;
        private String name;
    }

    @Data
    public static class FlaskRecommendRequestDto{
        private Long memberId;
        private Today today;
        private GymType goal1;
        private GymType goal2;
        private List<RecentExerciseDto> RecentExerciseDtos = new ArrayList<>();

    }

    @Data
    public static class RecentExerciseDto{
        private Long exerciseId;
        private Integer satisfaction;
    }

    @Data
    public static class FlaskRecommendResponseDto{
        private List<Long> GymId;
    }


    @Data
    public static class GymReportResponseDto{
        private Long gymId;
        private String gymType;
        private String gymInformation;
        private String gymUrl;
        private String gymName;
    }

    @Data
    public static class GymReportResponseDtos {
        private List<GymReportResponseDto> gyms = new ArrayList<>();
    }


    @Data
    public static class GymReportCompleteRequestDto{
        private Long memberId;
        private LocalDateTime endTime;
        private Integer duration;

        public GymReportCompleteRequestDto(){

        }
    }
    @Data
    public static class GymReportCompleteResponseDto{
        private Long totalGymKcal;
        private List<GymKcalDto> gymKcalDtos = new ArrayList<>();
        public GymReportCompleteResponseDto(){
        }

    }

    @Data
    public static class GymKcalDto{
        private Long gymId;
        private Double gymTotalKcal;
        public GymKcalDto(){

        }
    }

}
