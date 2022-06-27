import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class AppInitializer {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class,args);

    }
}
