### Soal
What does asm1(0x2e0) return? Submit the flag as a hexadecimal value (starting with '0x'). NOTE: Your submission for this question will NOT be in the normal flag format.
### Jawab
1. Download code
    
2. Code terlihat menggunakan assembly x86 (32 bit), dikarenakan di dalamnya tidak menggunakan register 64 bit sama sekali.
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeRw4ipPOQ6wspEkXNaEH3MB_LU4IHamzpwhJJQ4AkjBEjAq8VWXVGXD0GqlsQa6RRr5S2vhJc0WtRiirCOGWAhJvprhVHEiYwYFbVIQFOg_5vuiJyuXJWXe3y89OA4H4gbX9Xztg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

3. Di sini, kita tidak akan assemble codenya, karena penulisannya cukup aneh (mungkin assembly gas, bukan nasm). sehingga di sini kita akan memahami codenya dengan tracing saja.
    
4. Lihat code menggunakan text editor, atau menggunakan command “cat test.S”
    
5. perlu dicatat bahwa perintah dari soalnya adalah menggunakan parameter berupa nilai 0x2e0 (736), lalu flagnya adalah hasil dari function. (tanpa menggunakan “picoCTF{}”)
    
6. Analisis code:
    

7. Kode tersebut hanyalah penggalan kode saja, terlihat tidak ada sintaks global [label]
    
8. line 1: hanya label dari function
    
9. line 2-3: memindahkan data register ke stack, dan memindahkan data esp ke ebp (tidak terlalu perlu dihiraukan)
    
10. line 4: membandingkan (“cmp”), parameter (“DWORD PTR [ebp+0x8]”) dengan 0x3fb (1019). cmp akan mengubah nilai flag jump.
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXd-X3PyNGX2E3rtoDQaBagGUBzYPUmf-maWlw_MITJV0hGwAyZfcjqljm_NVsto9fsmP8KXIPwjKcV2YWs5p8wLikjatBFn9gG1MSd-E6-M9F_Aw9KboWMAUvg-nmdRtEH0QAJ5Jg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

5. line 5: jika hasilnya dari perbandingan (comparison/”cmp”) ialah nilai komparasi lebih besar(1019) dari parameter(736), maka, kode akan diteruskan pada line selanjutnya.
    
6. line 6:membandingkan lagi antara parameter (DWORD PTR [ebp+0x8]) dengan nilai komparasi 0x280 (640).
    
7. line 7: jika parameter dan nilai komparasi tidak sama (“jne” / jump not equal). maka kode lanjut ke line berikutnya
    
8. line 8: menyalin nilai parameter ke register eax
    
9. line 9: menambah nilai pada register eax dengan 0xa (10). dan ini hasilnya
    
10. line 10: jika line 7 tidak terpenuhi, maka kode akan jump ke line 10 dan kode akan berlanjut ke line berikutnya
    
11. line 11: menyalin nilai parameter ke register eax
    
12. line 12: mengurangi nilai eax dengan 0xa (10)
    
13. line 13: jika line 5 tidak terpenuhi, maka dari line 4, kode akan loncat ke line 13, dan line selanjutnya.
    
14. line 14: komparasi antara parameter dengan nilai komparasi 0x559 (1369)
    
15. line 15: jika hasil komparasi line 14 menunjukan kedua angka tidak sama (jne), maka kode akan dilanjutkan ke line berikutnya
    
16. line 16: menyalin data parameter ke register eax
    
17. line 17: mengurangi nilai data pada eax dengan 0xa (10)
    
18. line 18: jika line 15 tidak terpebuhi, maka kode akan loncat langsung ke line 18.
    
19. line 19: menyalin data parameter ke register eax
    
20. line 20: menambah nilai data eax dengan 0xa (10)
    
21. line 21: pop data dari stack 
    
22. line 22: return, membuat line intruksi yang dibaca kembali ke line yang memanggil fungsi ini.
    

23. Dari uraian tersebut, kita bisa menulis ulang kode tersebut dalam bahasa C (jika diperlukan, dilakukan agar lebih mudah dipahami oleh pembaca). menjadi
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXfeJM-1lnmpu_7jG_vFrWA3AQ48-_i1ArZIuSemU6rlrf0UQpda6iTdnCAD3gtMMnXiN2sow6gcEGrSBrf49rtxn85dl8LEmNcgoV_r4gEfAIYR4aPR8l8o1Qrpc3kwxEBUCXQN?key=YMCEdTyeqOPW5t0-YEJmFeQg)

8. Dengan begitu, kode terlihat sangat mudah untuk dimengerti, kita bisa tracing sendiri, dan hasilnya ialah 0x2e0 - 0xa = 736 - 10 = 726 = 2d6
    
9. maka flagnya ialah “0x2d6”