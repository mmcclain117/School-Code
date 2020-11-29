from PIL import Image


Image src, dest

float swirlX, swirlY, swirlRadius, swirlTwists
for(int y = 0; y < dest.height; y++) {
    for(int x = 0; x < dest.width; x++)    {
        // compute the distance and angle from the swirl center:
        float pixelX = (float)x - swirlX;
        float pixelY = (float)y - swirlY;
        float pixelDistance = sqrt((pixelX * pixelX) + (pixelY * pixelY));
        float pixelAngle = arc2(pixelY, pixelX);

        // work out how much of a swirl to apply (1.0 in the center fading out to 0.0 at the radius):
        float swirlAmount = 1.0f - (pixelDistance / swirlRadius);
        if(swirlAmount > 0.0f)
        {
            float twistAngle = swirlTwists * swirlAmount * PI * 2.0;

            // adjust the pixel angle and compute the adjusted pixel co-ordinates:
            pixelAngle += twistAngle;
            pixelX = cos(pixelAngle) * pixelDistance;
            pixelY = sin(pixelAngle) * pixelDistance;
        }
        // read and write the pixel
        dest.setPixel(x, y, src.getPixel(swirlX + pixelX, swirlY + pixelY));
    }
}