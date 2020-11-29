
import face_recognition
import os
import numpy as np
    
def faceRec(knownImage, unknownImage):
    knowImg = face_recognition.load_image_file(knownImage)    
    unknowImg = face_recognition.load_image_file(unknownImage)
    if face_recognition.face_encodings(unknowImg) == []: 
        print("No face Found")
        return False
    else:
        knowEncode = face_recognition.face_encodings(knowImg)[0]
        unknowEncode = face_recognition.face_encodings(unknowImg)[0]
        results = face_recognition.compare_faces([knowEncode], knowEncode)
        return results

def path(mypath):
    f= []
    for(dirName, subdirlist, fileList) in os.walk(mypath):
        print('Found directory: %s' % dirName)
        for fname in fileList:
            if "jpeg" in fname or "jpg" in fname:
                f.append(dirName + "\\" +  fname)
    print(f)
    return f

def main():
    ar = path(".")
    for x in range(0, len(ar) - 1):
        bo = faceRec("Examples\\Hannah (1).jpeg", ar[x])
        if bo:
            print("Hannah (1) == " + ar[x])
        else:
            print("Hannah (1) != " + ar[x])
main()