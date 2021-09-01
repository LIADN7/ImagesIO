# ImagesIO

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/img.jpg)

***

## Class:
* imagesActions -> Actions to perform on an image
* MyImageIO -> Reading and creating a JPG file
* examples -> Example of running the program

**Each color image is a collection of pixels,**

**Each pixel has a color represented on the computer by combining 3 intensities of the primary colors:**

**red**

**green**

**blue**

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/rgb.png)


***
## Explanation of the function in imagesActions:

* rgb2gray -> Turns a color image into black and white in O(H*W)

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/gray.png)

* rotate90 -> Rotate the image 90 degrees to the right in O(H*W)

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/90.png)

* Smooth -> Smoothing ןmage for parameter N in O(H*W*(n^2)) -->n is the parameter number

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/smooth.png)

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/smooth2.png)

* scaleup -> Image stretching by parameters H x W (height and width) in O((newH)*(newW))

![](https://github.com/LIADN7/ImagesIO/blob/master/img/git/scelap.png)




**[@author liadn7](https://github.com/liadn7)**
