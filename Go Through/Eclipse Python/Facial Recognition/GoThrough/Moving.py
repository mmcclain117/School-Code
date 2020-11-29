# Moving the files from one place to another - Take off main 3

import face_recognition
import os
import shutil

def move(a):
    shutil.copyfile(a, "C:\\Users\\maste\\Dropbox\\Coding Projects\\Python\\Face Rec 1\\this\\" + (os.path.split(a)[1]))
    
def faceDetect(image):
    image = face_recognition.load_image_file(image)
    if face_recognition.face_encodings(image) == []: 
        return False
    else:
        return True
        
def path(mypath):
    f= []
    for(dirName, subdirlist, fileList) in os.walk(mypath):
        print('Found directory: %s' % dirName)
        for fname in fileList:
            if "jpeg" in fname or "jpg" in fname or "png" in fname:
                f.append(dirName + "\\" +  fname)
            if "JPEG" in fname or "JPG" in fname or "PNG" in fname:
                f.append(dirName + "\\" +  fname)
    print(f)
    return f

def main():
    ar = path(".")
    for x in range(0, len(ar) - 1):
        if faceDetect(ar[x]):
            move(ar[x])
main()
