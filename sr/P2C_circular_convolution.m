%{
    Q. Write program to perform circular convolution
%}

clc;
close all;

x = [1 2 1 2];
h = [3 2 1 4];
N = max(length(x), length(h));
y = cconv(x, h, N); % Caculate circular convolution x & h
disp(y);

% % Manually performing circular convolution
% y = conv(x, h);
% ly = length(y);
% r = zeros(1, N);
% for i = 1:1:N
%     if(N + i <= ly)
%         r(i) = y(i) + y(N + i);
%     else
%         r(i)=y(i);
%     end
% end
% disp(r);

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
% plot(r);
xlabel('n--->');
ylabel('Amplitude--->');
title('Output Sequence');
