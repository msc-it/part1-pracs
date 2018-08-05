%{
    Q. Demonstrate thresholding (image enhancement technique)

Input parameters:
    - threshold value

The output is a binary image i.e. pixels are either black or white

The output image has white for all pixels with intensities greater than
the threshold value. The remaining pixels are black.
%}

clc
close all

% Read sample image
img = imread('moon.tif');
[row, col] = size(img);

% Assign the Threshold
threshold = 100;
% threshold = input('Enter the threshold (0-255): ');

% Create output binary image initialized with zeros (i.e. black)
binary = zeros(row, col);

% Loop through every pixel of the input image
for x = 1:1:row
    for y = 1:1:col
        % If the current pixel is greater than threshold
        % make it white in the binary image
        if img(x,y) > threshold % condition check on input image
            binary(x,y) = 255;  % value set on output image
        end
    end
end

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the thresholded binary image
subplot(1, 2, 2);
imshow(binary);
title('Threshold Image');