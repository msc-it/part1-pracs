%{
    Q. Demonstrate brightness adjustment (image enhancement technique)

Parameters:
    - offset

Simple operation where an offset is added to every pixel's intensity.

%}

clc
close all

% Read sample image
img = imread('moon.tif');

% Assign the offset
offset = 60;

% Perform Brightness adjustment
output = img + offset;

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the output
subplot(1, 2, 2);
imshow(output);
title('Brightness Adjusted image');