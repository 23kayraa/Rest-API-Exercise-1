package VizeSinavi.Cevaplar;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Cevap_3 {

    @GetMapping("/tarih-saat")
    public String getTarihSaat() {
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return getTarihSaat(istenenFormat);
    }

    private String getTarihSaat(DateTimeFormatter format) {
        LocalDateTime simdikiZaman = LocalDateTime.now();
        return simdikiZaman.format(format);
    }
        //Bu kodumuzda herhangi bir parametre yada input bulunmamakta rxecute ettğimiz zaman bize tarih ayarını döndürmekte
}
