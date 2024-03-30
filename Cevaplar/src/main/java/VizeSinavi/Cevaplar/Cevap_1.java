package VizeSinavi.Cevaplar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;


@RestController
public class Cevap_1 {
    @GetMapping("/siralaKelimeleri")
    public String[] siralaKelimeleri(@RequestParam String cumle) {
        String[] siralanmisKelimeler = siralaKelimeleriMetodu(cumle);
        return siralanmisKelimeler;
    }

    private String[] siralaKelimeleriMetodu(String cumle) {
        // Cümlenin kelimelerini boşluklara göre ayır
        String[] kelimeler = cumle.split("\\s+");

        // Her kelimeyi harf sırasına göre sırala
        Arrays.sort(kelimeler);

        // Sıralanmış kelimeleri döndür
        return kelimeler;
    }
}