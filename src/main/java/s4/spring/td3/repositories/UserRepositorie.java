package s4.spring.td3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td3.entities.Cuser;

public interface UserRepositorie extends JpaRepository<Cuser, Long>{
	//List<Cuser> findByORGANIZATION_ID(int ORGANIZATION_ID);
}
