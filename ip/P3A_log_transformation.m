%{
    Q. Demonstrate log transformation

Input parameters: NONE

Formula: (textbook page 44)

s = c * log(r + 1)

where, s => output image
       c => constant
       r => input image

We use r + 1, because input image may have pixels with intensities 0. log of
0 is infinity.

%}

clc
close all

% Read sample image
img = imread('moon.tif');
c = 1; % Adjust as required
output = c * log10(double(img) + 1);

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the transformed image
subplot(1, 2, 2);
imshow(output);
title('Log transformed image');