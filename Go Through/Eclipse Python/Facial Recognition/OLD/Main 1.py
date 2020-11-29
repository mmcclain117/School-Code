
import face_recognition
import os

#knowEncode = faceBase("Examples\\Hannah (1).jpeg")

def faceBase(knownImg):
    global knowEncode
    knowImg = face_recognition.load_image_file(knownImage)
    if face_recognition.face_encodings(unknowImg) == []: 
        print("choose another image")
        return null
    else:
        return face_recognition.face_encodings(knowImg)[0]
    
def faceRec(knownImage, unknownImage):
    knowImg = face_recognition.load_image_file(knownImage)    
    unknowImg = face_recognition.load_image_file(unknownImage)
    if face_recognition.face_encodings(unknowImg) == []: 
        return False
    else:
        knowEncode = face_recognition.face_encodings(knowImg)[0]
        unknowEncode = face_recognition.face_encodings(unknowImg)[0]
        results = face_recognition.compare_faces(knowEncode, knowEncode)
        return results

def path(mypath):
    #mypath = "C:\\Users\\maste\\Dropbox\\_School"
    f= []
    for(dirName, subdirlist, fileList) in os.walk(mypath):
        print('Found directory: %s' % dirName)
        #f.append(dirName)
        for fname in fileList:
            print('\t%s'% fname)
            f.append(dirName + "\\" +  fname)
    print(f)
    return f

def main():
    ar = path(".")
    for x in range(0, len(ar) - 1):
        if "jpeg" in ar[x] or "jpgs" in ar[x]:
            print(ar[x])
            if "Hannah (1).jpeg" in ar[x]: 
                print("it is blocked")
            #print(faceRec("Examples\\Hannah (1).jpeg", ar[x]))
            else:
                bo = faceRec("Examples\\Hannah (1).jpeg", ar[x])
                if bo:
                    print("Hannah (1) == " + ar[x])
                else:
                    print("Hannah (1) != " + ar[x])
        else:
            print(ar[x]+ " is not a valid picture file")

main()