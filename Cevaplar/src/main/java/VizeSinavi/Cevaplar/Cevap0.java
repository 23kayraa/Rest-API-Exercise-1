package VizeSinavi.Cevaplar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class Cevap0 {
    @GetMapping
    public String merhaba() {
        return "H5220031 Kayra Serindağ";
    }
}

