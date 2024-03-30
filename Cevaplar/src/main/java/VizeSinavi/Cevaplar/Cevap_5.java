package VizeSinavi.Cevaplar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
@RestController
public class Cevap_5 {
    @PostMapping("/dosyaIsleme")
    public ResponseEntity<String> dosyaIsleme(
            @RequestParam String klasorAdresi,
            @RequestParam String hedefDosyaAdi,
            @RequestParam long filtreBoyutuByte
    ) {
        try {
            String dosyaninTamAdresi = filtreleVeYaz(klasorAdresi, hedefDosyaAdi, filtreBoyutuByte);
            return new ResponseEntity<>("İşlem tamamlandı. Oluşturulan dosya: " + dosyaninTamAdresi, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("İşlem sırasında bir hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String filtreleVeYaz(String klasorAdresi, String hedefDosyaAdi, long filtreBoyutuByte) throws IOException {
        Path klasorYolu = Paths.get(klasorAdresi);
        Path hedefDosyaYolu = Paths.get(klasorAdresi, hedefDosyaAdi);

        try (BufferedWriter writer = Files.newBufferedWriter(hedefDosyaYolu)) {
            Files.walkFileTree(klasorYolu, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    long dosyaBoyutu = attrs.size();
                    if (dosyaBoyutu < filtreBoyutuByte) {
                        String dosyaSatiri = file.toAbsolutePath() + " - " + dosyaBoyutu + " bytes";
                        writer.write(dosyaSatiri);
                        writer.newLine();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }

        return hedefDosyaYolu.toAbsolutePath().toString();
    }
}