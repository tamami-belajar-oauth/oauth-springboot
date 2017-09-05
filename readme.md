# Belajar OAuth 2.0 

Paket yang dibutuhkan ada di pom.xml

Beberapa konfigurasi yang ada di application.properties yaitu :
1. konfigurasi db (belum terpakai, rencananya user password ditaruh di db)
2. flyway untuk melakukan update db saat build springboot
3. konfigurasi jackson agar tampilkan indentasi di output json

Flyway akan butuhkan konfigurasi di folder resources/db/migration dengan 
format seperti terlihat pada code.

Halaman `static/public.html` dapat dibuka oleh umum, sedangkan 
`templates/private.html` akan terproteksi oleh OAuth.

File Utama `OauthAuthServerApplication` berisi mapping ke `/private` 
dan _bean_ `authenticationManager` yang akan digunakan saat 
otentikasi sebagai penyedia user dan password login.

Pada paket `repo` dan `entity` berisi konfigurasi JPA untuk koneksi ke 
DB.

Kelas `config.AuthServerConfig` berisi tentang konfigurasi 
Otentikasi Server yang diturunkan dari kelas `AuthorizationServerConfigurerAdapter`.
 Kelas ini harus melakukan _override_ terhadap 3 _method_ `configure` yang
isinya tentang `security`, `client` dan `endpoint`.

Konfigurasi hak akses ada di `ResourceServerConfig` dimana 
disini akan dijelaskan mana halaman yang boleh diakses dan mana 
yang memiliki akses terbatas.

## Cara melakukan akses :

1. percobaan menggunakan PostMAN di chrome, memilih Basic Auth. Isikan username
   dan password seperti pada `AuthServerConfig` dimana user diisikan _clientId_
   dan password diisikan dengan _secret_. Gunakan POST dengan url berikut :
   `http://localhost:8080/oauth/token?grant_type=client_credentials&username=user&password=user`.
   Parameter grant_type diisikan seperti `authorizedGrantTypes` di kelas 
   `AuthServerConfig`, sedangkan username dan password diisikan dari 
   kelas `OauthAuthServerApplication` di _method_ / _bean_ `authenticationManager`
   
2. Server akan mengirimkan `access_token`, _copy_ kode ini.

3. Menggunakan PostMAN yang baru, coba akses ke url 
   `localhost:8080/private?access_token=` dengan parameter `access_token`
   diisi dengan _paste_ nilai sebelumnya. Kirimkan pada model Basic Auth
   dan metode GET.
   
4. Halaman akan diperbolehkan untuk dibuka.

