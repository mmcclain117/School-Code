#!/usr/bin/env python

#CodeWars 2017
#
# Hexagon Puzzle
#
#The input consists of seven lines, each with six capital letters. 
# Each line represents a single hexagon and each letter is a edge of the hexagon. 
# The letters are listed in clockwise order around the hexagon.
#W T J G N D
#X F W K C M
#M N X T R W
#B C V Q J G
#M T S D V K
#C F S G K B
#G T R M W C
#
#OUTPUT:
# The program must print a solution to puzzle. 
# There will actually be six possible orientations for the solution.
# The program only needs to print one orientation, but it may print all six.
# The hexagon sequence must be printed left-to-right, top-to-bottom.
# The first hexagon in the input is index zero, and the last is index six.
# After each index, the program must print the letter of the right edge.
# HINT: test your program with all the sample data.
#
# 4K 1X 2R 6C 5G 0J 3C
#
# Alternately, the program may print a graphical representation of the entire solution.
#      D   V   C   M
#       \ /     \ /
#    S---4---K---1---X
#       / \     / \
#  X   T   M   W   F   S
#   \ /     \ /     \ /
#N---2---R---6---C---5---G
#   / \     / \     / \
#  M   W   T   G   B   K
#       \ /     \ /
#    D---0---J---3---C
#       / \     / \
#      N   G   Q   V

hexIn = [['.' for x in range(6)] for x in range(7)] # 7x6 array of dots
hexOut = [['.' for x in range(6)] for x in range(7)] # 7x6 array of dots
hexUsed = [(0) for x in range(7)]
hexAssigned = [(0) for x in range(7)]
solutionsFound = [0 for x in range(1)]

import sys

def printHexOut(printGraphical):
	
	if (printGraphical == 1):
		print('      ',hexOut[1][4],'   ',hexOut[1][5],'   ',hexOut[2][4],'   ',hexOut[2][5], sep="")
		print('       \ /     \ /')
		print('    ',hexOut[1][3],'---',hexAssigned[1],'---',hexOut[1][0],'---',hexAssigned[2],'---',hexOut[2][0],sep='')
		print('       / \     / \ ')
		print('  ',hexOut[3][4],'   ',hexOut[1][2],'   ',hexOut[1][1],'   ',hexOut[2][2],'   ',hexOut[2][1],'   ',hexOut[4][0],sep='')
		print('   \ /     \ /     \ /')
		print('',hexOut[3][3],'---',hexAssigned[3],'---',hexOut[0][3],'---',hexAssigned[0],'---',hexOut[4][3],'---',hexAssigned[4],'---',hexOut[4][0],sep='')
		print('   / \     / \     / \ ')
		print('  ',hexOut[3][2],'   ',hexOut[3][1],'   ',hexOut[0][2],'   ',hexOut[0][1],'   ',hexOut[4][2],'   ',hexOut[4][1],'',sep='')
		print('       \ /     \ /')
		print('    ',hexOut[5][3],'---',hexAssigned[5],'---',hexOut[5][0],'---',hexAssigned[6],'---',hexOut[6][0],sep='')
		print('       / \     / \ ')
		print('      ',hexOut[5][2],'   ',hexOut[5][1],'   ',hexOut[6][2],'   ',hexOut[6][1],sep='')
		print('')		
	print (hexAssigned[1],hexOut[1][0],' ',hexAssigned[2],hexOut[2][0],' ',hexAssigned[3],hexOut[3][0],' ',hexAssigned[0],hexOut[0][0],' ',hexAssigned[4],hexOut[4][0],' ',hexAssigned[5],hexOut[5][0],' ',hexAssigned[6],hexOut[6][0],' ',sep='')
	return
	
# Check each location to see that the entries match placed neighbors
# Index locations for each hex start at right, going clockwise
# Location Map:     Index Map for each hexagon:
#  1   2                4 5
#3   0   4             3   0
#  5   6                2 1
def checkHex(hexLocation):
	if (hexLocation == 0): # Rightmost (0) letter must be first alphabetically
		if ((hexOut[0][0] > hexOut[0][1]) or (hexOut[0][0] > hexOut[0][2]) or (hexOut[0][0] > hexOut[0][3]) or (hexOut[0][0] > hexOut[0][4]) or (hexOut[0][0] > hexOut[0][5])):
			return 0
	if (hexLocation == 1):
		if (hexOut[1][1] != hexOut[0][4]):
			return 0
	if (hexLocation == 2):
		if ((hexOut[2][2] != hexOut[0][5]) or (hexOut[2][3] != hexOut[1][0])):
			return 0
	if (hexLocation == 3):
		if ((hexOut[3][0] != hexOut[0][3]) or (hexOut[3][5] != hexOut[1][2])):
			return 0
	if (hexLocation == 4):
		if ((hexOut[4][3] != hexOut[0][0]) or (hexOut[4][4] != hexOut[2][1])):
			return 0
	if (hexLocation == 5):
		if ((hexOut[5][5] != hexOut[0][2]) or (hexOut[5][4] != hexOut[3][1])):
			return 0
	if (hexLocation == 6):
		if ((hexOut[6][4] != hexOut[0][1]) or (hexOut[6][3] != hexOut[5][0]) or (hexOut[6][5] != hexOut[4][2])):
			return 0			
	# If we made it here, the Hex matches its neighbors
	return 1

# Place Hexagon <hexNumber> into location <hexLoxation>
# Rotate through all 6 sides for all but the first (0) hexLocation
# Location Map:     Index Map for each hexagon:
#  1   2                4 5
#3   0   4             3   0
#  5   6                2 1
def placeHex(hexNumber, hexLocation):
	hexUsed[hexNumber] = 1
	hexAssigned[hexLocation] = hexNumber
	rotationMax=6
	for rotation in range(rotationMax):
		# Place rotated hex
		for i in range(6):
			hexOut[hexLocation][i] = hexIn[hexNumber][((i+rotation)%6)] #rotate and use modulo 6 for index			
		# Check if it matches its neighbors
		if (checkHex(hexLocation)): #if the placement works, place the next hex
			if (hexLocation == 6): # we solved the problem!  Print!
				printHexOut(0); # change to a 1 to see a graphical print out.
				solutionsFound[0] = solutionsFound[0] + 1
				if ((solutionsFound[0]%6) == 0): # print Graphically for each sixth solution
					printHexOut(1);
			else:
				for j in range(7):
					if (hexUsed[j] == 0): # Only procede if the hex isn't used yet
						placeHex(j, hexLocation+1)  # RECURSIVE CALL TO PLACE EACH HEXAGON
    # After trying all rotations, mark this hex unused and return
	hexUsed[hexNumber] = 0

#-----------------------
#Main program starts here.
for i in range(7):
	line = sys.stdin.readline().rstrip('\n').rstrip(' ');
	letters = line.split()
	for j in range(6):
		hexIn[i][j]=letters[j]
		
# Debug Print the starting values
#for i in range(7):
#	print ('Hex ', i,': ',hexUsed[i],', ', sep='',end='');
#	for j in range(6):
#		print(hexIn[i][j],sep='',end='');
#	print('')
	
# Loop through all Hexes and place the center one.
for i in range(7):
	placeHex(i,0); # Place the hexagon in the center location

