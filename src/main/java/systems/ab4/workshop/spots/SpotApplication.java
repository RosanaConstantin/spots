package systems.ab4.workshop.spots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rosana-Constantin on 22-Jun-17.
 */
@SpringBootApplication
@EntityScan

public class SpotApplication {
    private static final Logger log = LoggerFactory.getLogger(SpotApplication.class);

    public static void main(String[] args){
        SpringApplication.run(SpotApplication.class, args);
    }

    @Bean

    public CommandLineRunner demo(LocationRepository locationRepository, SpotRepository spotRepository){
        return (args) -> {
            Location romania = new Location("Romania", null, LocationType.COUNTRY);

            Location ilfov = new Location("Ilfov", romania, LocationType.REGION);
            Location brasov = new Location("Brasov", romania, LocationType.REGION);
            Location constanta = new Location("Constanta", romania, LocationType.REGION);

            Location bucuresti = new Location("Bucuresti", ilfov, LocationType.TOWN);

            Location predeal = new Location("Predeal", brasov, LocationType.TOWN);
            Location sinaia = new Location("Sinaia", brasov, LocationType.TOWN);

            Location mamaia = new Location("Mamaia", constanta, LocationType.TOWN);
            Location neptun = new Location("Neptun", constanta, LocationType.TOWN);
            Location vama = new Location("Vama", constanta, LocationType.TOWN);


            List<Location> locations = Arrays.asList(romania, ilfov, brasov, constanta, bucuresti, predeal, sinaia, mamaia, neptun, vama);

            locationRepository.save(locations);

            log.info("Locations found eith findAll():");
            log.info("-------------------------------");
            for(Location location: locationRepository.findAll()){
                log.info(location.toString());
            }
            log.info("");
        };
    }
}
