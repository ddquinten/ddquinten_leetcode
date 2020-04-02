a = "11"
b = "1"


if len(b) > len(a):
    temp = b
    b = a
    a = temp

a = a[::-1]
b = b[::-1]
print a
print b
c = ""
i = 0
carry = 0
while i < len(b):
    if a[i] == "1" and b[i] == "1":
        if carry == 1:
            c += "1"
        else:
            c += "0"
            carry = 1
    elif a[i] == "1" or b[i] == "1":
        if carry == 1:
            c += "0"
        else:
            c += "1"
    else:
        if carry == 1:
            c += "1"
            carry ==0
        else:
            c += "0"
    i += 1

while i < len(a):
    if carry == 1 and a[i] == "1":
        c += "0"
    elif carry == 1:
        c += "1"
        carry = 0
    else:
        c += "0"
    i += 1

          
if carry == 1:
    c += "1"
          

print c[::-1]