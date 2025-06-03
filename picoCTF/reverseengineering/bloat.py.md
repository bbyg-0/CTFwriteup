### Soal
Can you get the flag? Run this [Python program](https://artifacts.picoctf.net/c/105/bloat.flag.py) in the same directory as this [encrypted flag](https://artifacts.picoctf.net/c/105/flag.txt.enc).
### Jawab
1. Download code dan teks enc nya
    
2. Sebelum run codenya, pastikan kedua file tersebut ada di folder yang sama
    
3. Terlihat terdapat string global, yaitu a, yang menampung berbagai macam karakter non-control character secara terurut dari yang memiliki nilai paling kecil, hingga nilai paling besar. String ini lah yang akan digunakan untuk semua print yang ada di program ini.
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeeuK2L32GilzHCr0l4RdymvoDp-tP8hfhtKKgjjFq5zshomDgVp8COYWnME3MKinZf3evP-PLf0LstLmFu5sxKUweyvRp0AZRDoJWBsDdPYFKFAZipc2_buYDvATUYQ6QJyhzaCg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

4. Jika kita sandingkan dengan ascii table, nilai dari karakter ‘!’ pada a ialah di index 0, akan tetapi di ascii table ialah 33, sehingga gap antara angka index dengan nilai sebenarnya ialah 33.
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdaLcr9B-cmfd7ls83jUgO-awbr6luJvptVbT4eSRVC9r-iYdQ4G_LvbwnioOyHz8ZBlquAh3fx_JILgxgoPf0Iwe31gzoCZWOcfXgO_oWEMF2rA1Jginq7BqMcD3zWTUmNv4xu-g?key=YMCEdTyeqOPW5t0-YEJmFeQg)

5. Kita find and replace teks yang ada pada code tersebut, sehingga membuat semua karakter yang asalnya menggunakan string a, seperti “a[0]”, “a[12]”, atau “a[15]”. langsung menampilkan karakter sebenarnya, sehingga akan jauh lebih mudah untuk kita baca. yaitu, dengan command nvim atau vim: 
    

“:%s/a\[\(\d\+\)\]/\=printf(‘“%c”’, submatch(1)+33)/g”

penjelasan mengenai command:

SCOPE

1. command find and replace di vim/nvim memiliki format :scope/find/replace/scope2
    

FIND

2. %s: ialah scope yang berarti menangkap semua string atau karakter yang sama dengan find di seluruh dokumen, bukan hanya pada suatu baris tertentu saja, rentang baris tertentu, tetapi seluruh dokumen.
    
3. a\[: ialah string lateral, yang menangkap ‘a[’, kita harus menggunakan ‘\’ sebelum ‘[’ agar terbaca
    
4. \(\d\+\): ialah menangkap satu atau lebih angka, dan memasukkanya pada grup \1.
    
5. \]: karakter literal ‘]’
    

REPLACE

6. \=printf() ialah memrintahkan untuk print dengan format yang mirip dengan printf() pada bahasa c
    
7. ‘“%c”’ ialah format printnya dengan karakter, dan dilingkupi dengan 2 tanda kutip
    
8. submatch(1)+33: ialah angka yang telah kita ambil (pada poin 4) lalu menambahkannya dengan 33.
    

SCOPE2

9. g: ialah berarti yang dicatch bukanlah yang match pertama saja pada suatu baris, tetapi semuanya pada suatu baris.
    

10. Jika berhasil, anda akan melihat suatu karakter yang aneh, seperti ‘^?’, terlihat seperti 2 karakter akan tetapi satu karakter. sebetulnya itu adalah karakter kontrol yang dipaksa dicetak pada poin e, karakter tersebut ialah karakter del, karena pada awalnya, string yang direplace ialah “a[94]” yang mana karakter 94 pada a ialah ‘ ’, akan tetapi di ascii, karakter tersebut seharunya bernilai 32 (lebih kecil dari ‘!’), sehingga, perintah kita pada poin e membuat keganjilan, sebab string a tidak benar-benar berurut.
    
11. untuk memperbaiki itu, kita bisa menggunakan command pada vim/nvim yaitu
    

“:%s/\%d127/ /g”

penjelasan command:

1. %s: telah dijelaskan sebelumnya
    
2. \%d127: maksudnya menangkap karakter yang memiliki angka dalam bentuk desimal ialah 127 (karakter kontrol del ialah 127)
    
3.  : lalu menggantinya dengan ‘ ’ (spasi)
    

4. Setelah kedua command tersebut, keterbacaan kode jauh lebih mudah. dan kita bisa melihat bahwa teks plain dari password yang diminta ialah pada fungsi arg133(), pada code saya fungsi nya (setelah mengalaim 2 command sebelumnya) menjadi
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcrBu5AnKFzUSPIKhC3V2bIS52Y6iS8qMdHtuk4HjJ9I35-6L7yvW67qOmUV8A--tC6tqF8xVzReWHLOLJ2HczjIPFIaTcpN9JHtdabem1pqV8AKwDzlvp53bVE36rcaDWwRVixPw?key=YMCEdTyeqOPW5t0-YEJmFeQg)

9. Jelas sekali bahwa fungsi tersebut meminta satu argumen, dan apabila argumen tersebut ialah “happychance”, maka argumen tersebut akan mengembalikan true
    
10. Jalankan program dengan command “python3 bloat.flag.py”
    
11. anda akan ditanya password, anda cukup input “happychance” lalu enter
    
12. flag akan diprint oleh program
    
13. SEPELE