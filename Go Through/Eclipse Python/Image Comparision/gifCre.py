# Note Adjust to the size of the first picture

import imageio

# For quick gifs
def quick(): 
    images = []
    filenames = ["069.jpg", "00881.jpg"]
    for filename in filenames:
        images.append(imageio.imread(filename))
    imageio.mimsave('movie.gif', images)
 
quick()
