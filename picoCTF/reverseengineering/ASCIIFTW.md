### Soal
This program has constructed the flag using hex ascii values. Identify the flag text by disassembling the program.
### Jawab
1. Download executeable file
    
2. anda bisa diassemble dengan ida, dan anda akan melihat pada function main, terdapat runtutan nilai-nilai heksadesimal (yang sebenarnya adalah karakter-karakter dari flag) di simpan pada suatu address dengan patokan register rbp
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXchY3Tb8fViw0ddc5tvSpfLNK9CmF6ciriswJFiYfIeB-K9Ik7MxSI31t0840vqxn7Hih_FMkCxA97zUgm2bLZbhBw6Yw8-ozVnIVYusmM_q8kG-O2jLyGW9H-ItLJkyvJh-NOV4g?key=YMCEdTyeqOPW5t0-YEJmFeQg)

3. Kita bisa saja copas barisan tersebut lalu format dengan command find and replace di nvim, akan tetapi pekerjaan tersebut akan cukup rumit.
    
4. Karena itu baiknya kita gunakan tool gdb dengan command “gdb ./asciiftw” pada terminal kita
    
5. lalu kita inspect fungsi main dalam assembly dengan command “disassemble main”
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeonodSlgxdHLSIlipk0L95u2P8zvJhZ83HNd9Wzus1RV-WAHJQmHSScVfN1TQtG1Etclt6KFXjVvg7gEZy555zx6KXIGn2wJXFCNROrQOezl_bQVkoYkC9k4h8NA5KAxUE12YViw?key=YMCEdTyeqOPW5t0-YEJmFeQg)

6. Kita bisa lihat runtutan tersebut dimulai dari <+27> sampai <+147>, karena itu, kita akan jalankan program sampai pada <+147> dieksekusi, program akan freeze, sehingga tidak akan langsung keluar.
    
7. Untuk memenuhi keinginan di poin f, kita bisa menggunakan command “break *main+151” (setelah <+147> ialah <+151>)
    
8. lalu kita jalankan program dengan command “run”, program akan berjalan dan break/freeze pada poin yang telah kita tentukan.
    
9. Jika kita lihat pada <+27>, nilai-nilai heksadesimal tersebut dimasukkan dimulai dari address rbp-0x30 sampai rbp-0x12
    
10. Kita cetak semua nilai-nilai heksadesimal tersebut dengan command “x/31xb $rbp-0x30”
    

penjelasan command:

1. x : memperlihatkan nilai dari suatu pointer
    
2. 31 : memperlihatkan sebanyak 31 nilai
    
3. x : dalam format heksadesimal (kita bisa ganti dengan ‘c’ untuk memformatnya langsung ke dalam karakter, akan tetapi lebih sederhana jika kita buat dalam heksadesimal terlebih dahulu)
    
4. b : yang ditampilkan adalah data sebesar byte
    
5. $rbp-0x30 : pointer yang ditunjuk
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXc5sg8vvNR4_bcc2Jf5-KwujhX0JjqDpSsMVQJBsH5Vl-yQsxPiiuwmdVyeQVKwb6Q4tq9eRF0u8R0G-X5aa0RCQNGaznuSLfzspvKZSNIqjilflrsUMeQxvHEExKlSoqN6QIAhAg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

11. copas output tersebut ke dalam file text yang dibuka dengan nvim
    
12. jalankan command “:%s/\(0x\x\+\)://g” untuk menghapus address-address di kiri (yang dicetak biru)
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdIFl66RSPGNdcw4zlZnQ3wkLeOWny_39MKw6PMEuCroYX1yOLf0f5A2Xk9SOn4HYCszo7NvoV8xZO76iZA8SmrQjJN_Jy18NkGdifxGGYs_fial_qs0VEW_PEDOdfRi1yIhDzgKQ?key=YMCEdTyeqOPW5t0-YEJmFeQg)

13. Jalankan “:%s/\t\(0x\x\+\)/\=printf(“%c”, submatch(1))/g” untuk mengganti angka-angka heksadesimal tersebut menjadi karakter
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeUjYTpMG-xmLxdDnCBRHNKl-KNtTj12lcKeB6BBzH61Rgy8W1KJ_TczSvGBCMhH7ZhssLnGa4KjNKBQO-fb5gWo5oBFVeGWcns4osJY0q8arMSpj2c7XCN3DvygaO30AkfS0KxEQ?key=YMCEdTyeqOPW5t0-YEJmFeQg)

14. Jalankan “:%s/\n//g” untuk menghapus newline, sehingga semuanya menjadi sebaris
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXe8ID6w2h0eba5R33ghRe-38OwW5hfJtTCd_5bBLDQf_Xa7xsfs5ekyeyMXPlJio5oi7Phj7pM3fMcnDP9jVObQpGS_axBHyumYmw8XKIzfbRNw7pBicyNAZRan7tk5-qySV_5czA?key=YMCEdTyeqOPW5t0-YEJmFeQg)