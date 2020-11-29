
import os
from PIL import Image
from sys

try:
    img = Image.open("Cisco.jpeg")

except IOError:
    print("Unable to load image")
    sys.exit(1)
    
print("Format: {0}\nSize: {1}\nMode: {2}".format(img.format, 
    img.size, img.mode))
img = img.resize(Image.
blurred = img.filter(ImageFilter.BLUR)
blur = blurred.filter(ImageFilter.GaussianBlur)
blur = blur.
blur = blur.transpose(Image.ROTATE_270)
blur.save("blurred.png")

files = ['a.jpeg', 'b.jpeg', 'c.jpeg', 'd.jpeg']
result = Image.new("RGB", (800, 800))

for index, file in enumerate(files):
    path = os.path.expanduser(file)
    img = Image.open(path)
    img.thumbnail((400, 400), Image.ANTIALIAS)
    x = index // 2 * 400
    y = index % 2 * 400
    w, h = img.size
    print('pos {0},{1} size {2},{3}'.format(x, y, w, h))
    result.paste(img, (x, y, x + w, y + h))

result.save(os.path.expanduser('~/image.jpg'))