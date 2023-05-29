package fitrecommend.fitquest.repository;

import fitrecommend.fitquest.domain.Home;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor

public class HomeRepository {

    private final EntityManager em;

    public Home findOne(Long id){
        return em.find(Home.class, id);
    }
}
