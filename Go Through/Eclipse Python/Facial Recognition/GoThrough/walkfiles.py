#from os import walk
import os

mypath = "C:\\Users\\maste\\Dropbox\\_School"
#mypath = './Users/maste/Dropbox'
f= ["this"]
for(dirName, subdirlist, fileList) in os.walk(mypath):
    print('Found directory: %s' % dirName)
    f.append(dirName)
    #f.append(filenames)
    for fname in fileList:
        print('\t%s'% fname)
        f.append(fname)
    #break
print(f)
#print(os.walk("C:\\Users\\maste\\Dropbox\\_School"))
#arr = os.walk("C:\\Users\\maste\\Dropbox\\_School")

#print(arr)

