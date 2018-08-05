%{
    Q. Write program to perform 2D linear convolution
%}

clc;
close all;

x = [1 2; 3 4];  % 2D array (input signal)
h = 1:8;         % impulse signal
y = conv2(x, h); % 2D convolution

% Plot the input signal
subplot(3,1,1);
plot(x);
ylabel('Amplitude--->');
xlabel('n----->');
title('Input sequence');

% Plot the impulse signal
subplot(3,1,2);
plot(h);
xlabel('n---->');
ylabel('Amplitude--->');
title('Impulse Response--->');

% Plot the convoluted output signal
subplot(3,1,3);
plot(y);
xlabel('n--->');
ylabel('Amplitude--->');
title('Convoluted Output Sequence');
