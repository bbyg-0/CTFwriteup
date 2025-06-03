import sys
a = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ \
            "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ "
def arg133(arg432):
  if arg432 == "h"+"a"+"p"+"p"+"y"+"c"+"h"+"a"+"n"+"c"+"e":
    return True
  else:

    print("T"+"h"+"a"+"t"+" "+"p"+"a"+"s"+"s"+"w"+"o"+
"r"+"d"+" "+"i"+"s"+" "+"i"+"n"+"c"+"o"+"r"+\
"r"+"e"+"c"+"t")
    sys.exit(0)
    return False

def arg111(arg444):
  return arg122(arg444.decode(), "r"+"a"+"p"+"s"+"c"+"a"+"l"+\
"l"+"i"+"o"+"n")

def arg232():
  return input("P"+"l"+"e"+"a"+"s"+"e"+" "+"e"+"n"+"t"+\
"e"+"r"+" "+"c"+"o"+"r"+"r"+"e"+"c"+"t"+\
" "+"p"+"a"+"s"+"s"+"w"+"o"+"r"+"d"+" "+\
"f"+"o"+"r"+" "+"f"+"l"+"a"+"g"+":"+" ")

def arg132():
  return open('flag.txt.enc', 'rb').read()

def arg112():
  print("W"+"e"+"l"+"c"+"o"+"m"+"e"+" "+"b"+"a"+"c"+\
"k"+"."+"."+"."+" "+"y"+"o"+"u"+"r"+" "+"f"+\
"l"+"a"+"g"+","+" "+"u"+"s"+"e"+"r"+":")

def arg122(arg432, arg423):
    arg433 = arg423
    i = 0
    while len(arg433) < len(arg432):
        arg433 = arg433 + arg423[i]
        i = (i + 1) % len(arg423)        
    return "".join([chr(ord(arg422) ^ ord(arg442)) for (arg422,arg442) in zip(arg432,arg433)])

arg444 = arg132()   #expected
arg432 = arg232()   #user input
arg133(arg432)
arg112()
arg423 = arg111(arg444)
print(arg423)
sys.exit(0)

