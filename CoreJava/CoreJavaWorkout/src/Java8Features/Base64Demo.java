package Java8Features;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class Base64Demo {

	public static void main(String[] args) throws MalformedURLException {
		
		String msg="Welcome im java 8 feature";
		Base64.Encoder encoder=Base64.getEncoder();
		String encodedmsg=encoder.encodeToString(msg.getBytes());
		System.out.println("Encoded message:"+encodedmsg);
		
		//decoding
		Base64.Decoder decoder=Base64.getDecoder();
		String decodemsg=new String(decoder.decode(encodedmsg));
		System.out.println("Decoded message:"+decodemsg);
		
		URL url=new URL("http://www.neosofttech.com");
		System.out.println("original url:"+url);
		
		//url encoding 
		Base64.Encoder urlencode=Base64.getUrlEncoder();
		String encodeurl=urlencode.encodeToString(url.toString().getBytes());
		System.out.println("Encoded url:"+encodeurl);
		
		//decode url
		Base64.Decoder url_decode=Base64.getUrlDecoder();
		String decodeurl=new String(url_decode.decode(encodeurl));
		System.out.println("Decoded url:"+decodeurl);
		
	}

}
