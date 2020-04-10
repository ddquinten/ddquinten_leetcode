List = [1, 2, 4, 2, 1]

#xor soultion
for i in range(1,len(List)):
	List[0] = List[0] ^ List[i]
print List[0]


# bad soulion
"""while(True):
    if len(List) == 1:
        print (List[0]);
        break;
    if List[0] not in List[1:len(List)]:
        print (List[0]);
        break;
    else:
        List = List[1:len(List)];"""
