%{
    Q. Morphological closing

Input parameter:
    - Structuring element

Formula: (A ⊕ B) ⊖ B
    where, A => Input image
           B => Structuring element


%}

clc
close all

% Read sample image
img = imread('cameraman.tif');

% Create structuring element
% se = strel('square', 11); % using inbuilt function
se = ones(11,11); % use if inbuilt function is not allowed
                  % the dimension should be a square nxn matrix
                  % and n should be odd since center pixel is assumed to be
                  % the origin

% Use the formula
temp = imdilate(img,se);
output = imerode(temp, se);

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the histogram
subplot(1, 2, 2);
imshow(output);
title('After closing operation');