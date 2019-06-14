% Abrantes Araújo Silva Filho
% abrantesasf@gmail.com

m = 3;
n = 3;
k = 3;

C = [ 1 4 7
      2 5 8
      3 6 9 ];
disp("Matrix C:");
disp(C);

A = [ 10 13 16
      11 14 17
      12 15 18 ];
disp("Matrix A:");
disp(A);  

B = [ 19 22 25
      20 23 26
      21 24 27 ];
disp("Matrix B:");  
disp(B);  

disp(" ");
disp('Calculating "C +:= A * B", with PIJ ordering:');
disp(" ");

for p = 0:(k-1)
    for i = 0:(m-1)
        for j = 0:(n-1)
            disp("p = " + p + "; i = " + i + "; j = " + j);
            disp("   gamma_" + i + "," + j + " := " + "(alpha_" + i + "," + p + ")(beta_" + p + "," + j + ") + gamma_" + i + "," + j);
            disp("   gamma_" + i + "," + j + " := " + A(i+1,p+1) + " * " + B(p+1,j+1) + " + " + C(i+1,j+1));
            C(i+1,j+1) = A(i+1,p+1) * B(p+1,j+1) + C(i+1,j+1);
        end
        disp(C);
        disp(" ");
    end
    disp(" ");
end