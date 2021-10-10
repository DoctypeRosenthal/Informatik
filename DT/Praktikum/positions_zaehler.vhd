library ieee;
use ieee.std_logic_1164.all;
USE ieee.std_logic_arith.ALL;

entity positions_zaehler is
  port 
  (
    Clk             : in  std_logic;
    Reset           : in  std_logic;
    Enable	        : in  std_logic;	
    UpNotDown       : in  std_logic;	
    ClearA         : in  std_logic; 
    ClearB        : in  std_logic; 
    
    CountOut       : out std_logic_vector(15 downto 0)	
  );
end positions_zaehler;




ARCHITECTURE behv OF positions_zaehler IS
BEGIN
	process(Reset, Clk, Enable, UpNotDown)
	variable var_cnt: integer range 0 to 65535;
	begin
	   if Reset = '1' then
			var_cnt := 32700;
		elsif Enable = '1' and Clk'event and Clk ='1' then 
			if ClearA = '1' or ClearB = '1' then
			     var_cnt := 32768;
			else
			     -- count
			     if UpNotDown = '1' then
			         -- count up
			         if var_cnt = 65535 then var_cnt := 0;  -- catch overflow
			         else var_cnt := var_cnt + 1;
			         end if;
			     else
			         -- count down
			         if var_cnt = 0 then var_cnt := 65535; -- catch overflow
			         else var_cnt := var_cnt - 1;
			         end if;
			     end if;
			end if;
		end if;
		
	   CountOut <= conv_std_logic_vector(var_cnt,16);
	end process;
END behv;
