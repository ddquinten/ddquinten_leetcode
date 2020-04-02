prompt = "Enter an integer: ";

number = input(prompt);
roman = "";

x = int(number);
icount = vcount = mcount = 0;

# 1000
while (x >= 1000):
	roman += "M"
	x -= 1000; 

# 900 - 100
if ((x - 900) >= 0):
	roman += "CM";
	x -= 900;
elif ((x - 500) >= 0):
	roman += "D";
	x -= 500;
elif ((x - 400) >= 0):
	roman += "CD";
	x -= 400;
while (x >= 100):
	roman += "C";
	x -= 100;

# 90 - 10
if ((x - 90) >= 0):
	roman += "XC";
	x -= 90;
elif ((x - 50) >= 0):
	roman += "L";
	x -= 50;
elif ((x - 40) >= 0):
	roman += "XL";
	x -= 40;
while (x >= 10):
	roman += "X";
	x -= 10;

# 9 - 1
if ((x - 9) >= 0):
	roman += "IX";
	x -= 9;
elif ((x - 5) >= 0):
	roman += "V";
	x -= 5;
elif ((x - 4) >= 0):
	roman += "IV";
	x -= 4;
while (x >= 1):
	roman += "I";
	x -= 1;



print(roman);