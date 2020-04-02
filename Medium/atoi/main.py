from myAtoi import myAtoi as atoi
# can import specfic functions from files and give it an alias
# from 'filename' import 'functionname' as 'alias'


string = input("Enter a string to be converted to integer: ")

integer = atoi(string)

print('\nOriginal:' + '\n' + string)
print('Converted:')
print(integer)

