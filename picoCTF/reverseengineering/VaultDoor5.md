### Soal
In the last challenge, you mastered octal (base 8), decimal (base 10), and hexadecimal (base 16) numbers, but this vault door uses a different change of base as well as URL encoding!
### Jawab
1. Download source code yang tersedia
    
2. Lihat function checkPassword
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcinmqxaN_xLJH8qXWwVYjEtR0nTuSCgkqaUzpeQRSlBZh3d_igokxxszxurFs_nuiTVNzesKBnpjx4QAvHW_04V19zMzX5V4xRlmhJbEdLfJ2Zsi0dP6LNo1ajC9i22TuvLFee5Q?key=YMCEdTyeqOPW5t0-YEJmFeQg)

3. Cara kerjanya mirip dengan VaultDoor3, yaitu, input dari user akan diubah dengan berbagai operasi, lalu akan disamakan dengan sebuah string, yang pada kali ini ialah string expected pada line 31 di gambar.
    
4. Runtutan operasinya adalah:
    

5. Input dipecah karakternya menjadi bytes
    
6. format base dari nilai karakter diubah dari desimal ke heksadesimal
    
7. Encode dengan base64
    

8. Sehingga yang perlu kita lakukan adalah sebaliknya, yaitu:
    

9. Decode dari base64
    
10. format dari heksadesimal menjadi desimal
    
11. Satukan kembali menjadi suatu string
    

12. Buat line 7-10 menjadi comment, karena tidak diperlukan.
    
13. Deklarasi String input dengan nilai yang sama dengan string expected pada line 31
    
14. Buat variable baru yang memiliki nilai hasil decode variable String input, dengan command:
    

byte[] base64decode = Base64.getDecoder().decode(input);

9. Format semua nilai dari base64decode dari heksadesimal menjadi desimal, dengan membuat function nya terlebih dahulu
    

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXfgq0mS2X4CRMfa7KniS3Q9xEHkjZsCp5__IYUn3zriEm3kJrZ0dko6iSGMAu2mF16Xv-3jI-666MvXy32u82YuRasyEPw39F7elrmuGeEdrXUANMPAFmibjNELIj9NRAmC6-9Mbg?key=YMCEdTyeqOPW5t0-YEJmFeQg)

lalu, masukkan nilainya pada array integer baru, yaitu, toDecimal, tetapi hanya setiap nilai ke-2 dan ke-3 dari 3 nilai, karena, nilai dari 0, 3, 6 (kelipatan 3), hanyalah karakter ‘%’. lalu, buat command output pada setiap kali nilai diassign ke toDecimal dengan mengcastingnya terlebih dahulu ke format karakter (lihat pada line 20 di gambar)

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdp0JVETtSZpfmZdRy9TPq7xA_KaHWyW2r0gXKxx2rVXK9gzIbaMPkQFXLB0OHYW2_HqoritE1XoYBPGNboyXv64H6S6UmvH7l9WQzgeKrx5yiVmErOltJYgHCkrDh3oNKQL4wB8g?key=YMCEdTyeqOPW5t0-YEJmFeQg)

10. compile dan run, access denied, akan tetapi, program akan memperlihatkan flagnya.