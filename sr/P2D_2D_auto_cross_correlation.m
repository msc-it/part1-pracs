%{
    Q. Write program to perform 2D cross correlation and 2D autocorrelation
    Reference: http://dsp.cs.cmu.edu/notes/intro_to_signals/signals.html
%}

clc;
close all;

x = [1 2; 3 4];  % 2D array (input signal)
h = [5 6; 7 8];  % 2D array (impulse signal)
y = xcorr2(x,h); % 2D Cross correlation of x with h
y2 = xcorr2(x);  % 2D Auto correlation of x

% Plot the input signal
subplot(4,1,1);
plot(x);
ylabel('Amplitude--->');
xlabel('n----->');
title('Input sequence');

% Plot the impulse signal
subplot(4,1,2);
plot(h);
xlabel('n---->');
ylabel('Amplitude--->');
title('Impulse Response--->');

% Plot autocorrelation of x
subplot(4,1,3);
plot(y2);
xlabel('n--->');
ylabel('Amplitude--->');
title('Autocorrelation');

% Plot the 2D Cross correlated signal
subplot(4,1,4);
plot(y);
xlabel('n--->');
ylabel('Amplitude--->');
title('2D Cross Correlation');
