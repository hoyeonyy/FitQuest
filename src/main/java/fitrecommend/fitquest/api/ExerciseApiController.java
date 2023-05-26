package fitrecommend.fitquest.api;

import fitrecommend.fitquest.domain.*;
import fitrecommend.fitquest.repository.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExerciseApiController {

    private final ExerciseJPARepository exerciseJPARepository;

    private final GymReportJPARepository gymReportJPARepository;

    private final MemberRepository memberRepository;

    private final SetJPARepository setJPARepository;

    private final GymJPARepository gymJPARepository;



    @PostMapping("/gym/exercise/complete")
    public ResponseEntity<ExerciseCompleteResponseDto> exerciseComplete(@RequestBody  ExerciseCompleteRequestDto exerciseCompleteRequestDto){
        ExerciseCompleteResponseDto exerciseCompleteResponseDto = new ExerciseCompleteResponseDto();
        Member member = memberRepository.findOne(exerciseCompleteRequestDto.getMemberId());
        List<GymReport> gymAllReports = gymReportJPARepository.findByMember(member); // 회원이 가지고있는 모든 보고서를 조회한다.
        GymReport gymReport = gymAllReports.get(gymAllReports.size()-1);
        Exercise exercise = exerciseJPARepository.findByGymReportAndGymId(gymReport, exerciseCompleteRequestDto.getGymId());

        for(Integer lep : exerciseCompleteRequestDto.getLeps()){
            Sets sets = new Sets();
            sets.setExercise(exercise);
            sets.setRep(lep);
            exercise.getSets().add(sets);
            setJPARepository.save(sets);
        }
        exercise.setComplete(Complete.YES);
        exercise.setTotalKcal(exercise.getTotalKcal());
        exerciseJPARepository.save(exercise);
        exerciseCompleteResponseDto.setState("Success");
        return ResponseEntity.ok(exerciseCompleteResponseDto);
    }

    @PostMapping("/gym/exercise/satisfaction")
    public ResponseEntity<GymReportSatisfactionResponse> exerciseSatisfaction(@RequestBody GymReportSatisfactionRequest gymReportSatisfactionRequest){
        Member member = memberRepository.findOne(gymReportSatisfactionRequest.getMemberId());
        GymReportSatisfactionResponse gymReportSatisfactionResponse = new GymReportSatisfactionResponse();
        List<GymReport> gymAllReports = gymReportJPARepository.findByMember(member); // 회원이 가지고있는 모든 보고서를 조회한다.
        GymReport gymReport = gymAllReports.get(gymAllReports.size()-1);
        gymReport.setName(gymReportSatisfactionRequest.getReportName());
        for(SatisfactionDto satisfactionDto: gymReportSatisfactionRequest.getSatisfactionDtos()){
            Exercise exercise = exerciseJPARepository.findByGymReportAndGymId(gymReport, satisfactionDto.getGymId());
            exercise.setSatisfaction(satisfactionDto.getSatisfaction());
            exerciseJPARepository.save(exercise);
        }
        gymReportSatisfactionResponse.setState("Success");
        return ResponseEntity.ok(gymReportSatisfactionResponse);
    }

    @Data
    public static class ExerciseCompleteRequestDto{
        private Long memberId;
        private Long gymId;
        private List<Integer> leps = new ArrayList<>();

        public ExerciseCompleteRequestDto(){

        }
    }

    @Data
    public static class ExerciseCompleteResponseDto{
        private String state;
        public ExerciseCompleteResponseDto(){
        }
    }

    @Data
    public static class GymReportSatisfactionRequest{
        private Long memberId;
        private String ReportName;
        private List<SatisfactionDto> satisfactionDtos = new ArrayList<>();
        public GymReportSatisfactionRequest(){

        }
    }


    @Data
    public static class SatisfactionDto{
        private Long gymId;
        private Integer satisfaction;
        public SatisfactionDto(){
        }
    }



    @Data
    public static class GymReportSatisfactionResponse{
        private String state;
        public GymReportSatisfactionResponse(){
        }
    }
}
