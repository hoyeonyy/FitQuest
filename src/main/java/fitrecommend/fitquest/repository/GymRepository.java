package fitrecommend.fitquest.repository;

import fitrecommend.fitquest.domain.Gym;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GymRepository {
    private final EntityManager em;

    public Gym findOne(Long id){
        return em.find(Gym.class, id);
    }
}
