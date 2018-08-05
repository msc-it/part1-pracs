%{
    Q. Power law transformation (used in gamma correction)

Input parameters:
    - Gamma (γ)

Formula: (textbook page 45)

s = c * r ^ γ

where, c, γ => positive constants
       r => input image
       s => output image
%}

clc
close all

% Read sample image
img = imread('moon.tif');
gamma = 1/2.5;
c = 20;
output = c * (double(img) .^ gamma);

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the transformed image
subplot(1, 2, 2);
imshow(uint8(output));
title('Power law transformed image');