%{
    Q. Demonstrate contrast stretching (image enhancement technique)

Input Parameters:
    - Lower limit   (a or s1)
    - Upper limit   (b or s2)
    - Lowest value  (c or r1)
    - Highest value (d or r2)

The operation increases image contrast by making the dark regions darker
and bright regions brighter. This is done by defining an upper limit (a) and
lower limit (b). The intensities of the input image is adjusted such that
the output image only has intensities between a and b.

Formula for contrast stretching (from text book page 49):

       (Pin - c)(b - a)
Pout =          _______ + a
                (d - c)

where Pout is output image and Pin is input image image

%}

clc
close all

% Read sample image
img = imread('moon.tif');
[row, col] = size(img);

% Assign input parameters
% Upper and lower intensity range in output image:
a = 80;
b = 255;
% Max and min intensities of the image:
c = min(img(:)); % (:) converts the 2D array into a 1D array
d = max(img(:));

% Use the formula to apply contrast stretching
output = (img - c) .* ((b - a)/(d - c)) + a; % the .* operator multiples the
                                             % value to each element of the
                                             % image matrix

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the output
subplot(1, 2, 2);
imshow(output);
title('Contrast Stretching Applied');