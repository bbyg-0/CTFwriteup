section .data
    out_fmt db "Hasil: %d", 10, 0     ; format string untuk printf

section .text
    extern printf
    global main
    global asm1

main:
    ; contoh argumen = 1000
    push    1000
    call    asm1
    add     esp, 4

    push    eax         ; simpan hasil ke stack untuk printf
    push    out_fmt
    call    printf
    add     esp, 8

    mov     eax, 0
    ret

asm1:
    push    ebp
    mov     ebp, esp
    mov     eax, [ebp + 8]       ; ambil parameter pertama
    cmp     eax, 0x3FB
    jg      greater_than_0x3fb

    cmp     eax, 0x280
    jne     less_than_0x280
    add     eax, 0xA
    jmp     done

less_than_0x280:
    sub     eax, 0xA
    jmp     done

greater_than_0x3fb:
    cmp     eax, 0x559
    jne     add_10
    sub     eax, 0xA
    jmp     done

add_10:
    add     eax, 0xA

done:
    pop     ebp
    ret
