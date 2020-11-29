from PIL import Image
from jupyter_client.kernelspecapp import raw_input
import string

def atmp1():
#    Image._show(str);
    try:
        im = Image.open('C:\\Users\\maste\\Desktop\\Corrupted Photo\\Corrupted Photo.JPG')
    except:
        print("This isN'T WORKING!!!")
    print("Made it here");
#    print(im.getbbox());
    im.resize((1000,1000));
    im.save('Corrupt.jpg')
    
filename = 'C:\\Users\\maste\\Desktop\\Eclipse Python\\Image Comparision\\img\\0 e.jpg'
def atmp2():
    #file = input("Enter the file name: ")
    img = filename
#    img = raw_input(filename)
#    img = raw_input(file)
    print(img)
    if img and img.meta_type == 'Image':
        pilImg = PIL.Image.open( StringIO(str(img.data)) )
    elif imgData:
        pilImg = PIL.Image.open( StringIO(imgData) );
    try:
        pilImg.load();
    except IOError:
        pass # You can always log it to logger
    pilImg.thumbnail((width, height), PIL.Image.ANTIALIAS)
    
atmp2();