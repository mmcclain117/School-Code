from PIL import Image, ImageFilter
import sys

try:
    img = Image.open("Cisco.jpeg")

except IOError:
    print("Unable to load image")
    sys.exit(1)
    
# img.show()
print("Format: {0}\nSize: {1}\nMode: {2}".format(img.format, 
    img.size, img.mode))
blurred = img.filter(ImageFilter.BLUR)
blur = blurred.filter(ImageFilter.GaussianBlur)
blur = blur.
blur = blur.transpose(Image.ROTATE_270)
blur.save("blurred.png")


