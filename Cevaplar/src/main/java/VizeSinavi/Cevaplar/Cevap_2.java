package VizeSinavi.Cevaplar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Cevap_2 {

    @GetMapping("/Hesaplama")
    public String matematikselHesapla(@RequestParam double sayi1, @RequestParam double sayi2, @RequestParam String op) {
        double sonuc = hesapla(sayi1, sayi2, op);
        return sonuc != -1 ? "Sonuç: " + sonuc : "Hesaplama hatası!";
    }

    private double hesapla(double sayi1, double sayi2, String op) {
        double sonuc = -1;

        switch (op) {
            case "+":
                sonuc = sayi1 + sayi2;
                break;
            case "-":
                sonuc = sayi1 - sayi2;
                break;
            case "*":
                sonuc = sayi1 * sayi2;
                break;
            case "/":
                if (sayi2 != 0) {
                    sonuc = sayi1 / sayi2;
                } else {
                    System.out.println("Hata: Sıfıra bölme hatası!");
                }
                break;
            default:
                System.out.println("Hata: Tanımsız operatör!");
        }

        return sonuc;
    }
}