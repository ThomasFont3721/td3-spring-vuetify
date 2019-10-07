package s4.spring.td3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td3.entities.Cgroupe;

public interface GroupRepositorie extends JpaRepository<Cgroupe, Long>{
}
