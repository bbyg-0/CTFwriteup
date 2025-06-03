### Soal
This vault uses an XOR encryption scheme.
### Jawab
1. Download source code
    
2. lihat function yang memeriksa validasi dari password
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeOTr7p8_RDZ7d7r64cSUIoHRUkYEjFn0UjvnjybPUehTi2HpPHVJjKFpYkZ2YtaZAweAVkAwAjSGUBbMAT060RjDuDVV1c2eoXHhJmkNpBIcSDwyPNGTtLbZ2IQg0zBUbCd_yg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

Kode tersebut, memeriksa password dengan memeriksa karakternya satu per satu, dengan mengoperasikan XOR dengan bilangan heksadesimal 0x55, lalu dikurangi dengan nilai-nilai yang ada pada myBytes

3. Perlu diingat bahwa A ^ B = C; maka C ^ B = A dan (A ^ B) - C !=0; maka (A^B) != C
    
4. Buat line 6-14 menjadi komen, karena kita tidak membutuhkannya
    
5. buat array byte dengan nilai yang sama dengan array byte myBytes. buat di dalam main.
    
6. buat variable byte dengan nilai 0x55
    
7. buat command looping yang menampilkan hasil operasi antara nilai myBytes dengan 0x55 dalam format karakter, hasil dari menampilkan karakter dengan looping tersebut ialah flagnya