%{
    Q. Negation (basic transformations)

Input parameters: NONE

Formula: (textbook page 45)

s = L - 1 - r

where, L => no of possible intensity values
       r => input image
       s => output image
%}

clc
close all

% Read sample image
img = imread('moon.tif');
L = 256;
output = L - 1 - img;

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the negative image
subplot(1, 2, 2);
imshow(output);
title('Negative image');