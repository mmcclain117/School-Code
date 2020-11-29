import face_recognition


def main():
    image = "";
 #   try:
    image = face_recognition.load_image_file("Examples\\Hannah (1).jpeg")
#    except Exception:
 #       pass
    # image = face_recognition.load_image_file("Examples\\Hannah (4).jpeg")
    face_locations = face_recognition.face_locations(image)
    print(face_locations)
#    face_landmarks_list = face_recognition.face_landmarks(image)
#    print(face_landmarks_list)
    print("this")
    
    known_image = face_recognition.load_image_file("Examples\\Hannah (4).jpeg")
    print("that")
    unknown_image = face_recognition.load_image_file("Examples\\Hannah (2).jpeg")
    print(face_recognition.face_encodings(known_image) == [])
    biden_encoding = face_recognition.face_encodings(known_image)[0]
    unknown_encoding = face_recognition.face_encodings(unknown_image)[0]
    print(biden_encoding)
    print(unknown_encoding)
    results = face_recognition.compare_faces([biden_encoding], unknown_encoding)
    print(results)
    
main()