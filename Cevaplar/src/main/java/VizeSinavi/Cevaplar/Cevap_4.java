package VizeSinavi.Cevaplar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.InetAddress;
import java.net.UnknownHostException;
@RestController
@RequestMapping("/ip")
public class Cevap_4 {

    @PostMapping("/dogrula")
    public ResponseEntity<Boolean> dogrula(@RequestBody String ip) {
        try {
            InetAddress.getByName(ip);
            return ResponseEntity.ok(true); // IP adresi doğru
        } catch (UnknownHostException e) {
            return ResponseEntity.ok(false); // IP adresi hatalı
        }
    }
    //Verilen İp adresini doğrular eğer verilen adres bir ip değeri ise true döndürür
}

