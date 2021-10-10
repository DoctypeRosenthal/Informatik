library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;

entity steuerung is
  port 
  (
    Clk            : in std_logic;
    Reset           : in std_logic;
    AktPos          : in std_logic_vector(15 downto 0);
    Notaus          : in std_logic; 
    Betrieb         : in std_logic; 
    HPR             : in std_logic;   
    HPL             : in std_logic;
    ESR             : in std_logic;
    ESL             : in std_logic;
    
    CntClr	        : out std_logic;
    LedR            : out std_logic;	
    LedG            : out std_logic;	    
    M_An            : out std_logic;
    M_Li            : out std_logic;
    M_Re            : out std_logic;
    State           : out std_logic_vector(7 downto 0)
  );
end steuerung;

architecture BEHAVE of steuerung is
begin
    process(Clk, Reset, AktPos, Notaus, Betrieb, ESR, ESL)
        TYPE ZUSTAND IS (starte_hoch, starte_runter, hoch, runter, steht, notfall);
        VARIABLE var_zustand: ZUSTAND; 
        VARIABLE var_out_vec: std_logic_vector (2 DOWNTO 0); 
    begin
        if Betrieb = 'U' or Reset = '1' then
            -- initialisieren
            var_zustand := steht;
        end if;
            
        -- Definition des Verhaltens hinsichtlich der Zustandsänderungen
        IF Notaus = '1' THEN
            var_zustand := notfall;
        ELSIF CLK'event and CLK ='1' THEN
            CASE var_zustand IS
                WHEN steht =>
                    IF ESL = '1' THEN
                        -- anfahren nach unten
                        var_zustand := starte_runter;
                    ELSIF ESR = '1' THEN
                        -- anfahren nach oben
                        var_zustand := starte_hoch;
                    END IF;
                WHEN starte_runter =>
                    if not ESL = '1' then
                        var_zustand := runter;
                    end if;
                WHEN starte_hoch =>
                    if not ESR = '1' then
                        var_zustand := hoch;
                    end if;  
                WHEN runter =>
                    IF ESL = '1' THEN
                        -- anfahren nach unten
                        var_zustand := starte_runter;
                    ELSIF conv_integer(AktPos) >= 48768 THEN 
                        -- Rolltreppe ist unten
                        var_zustand := steht;
                    END IF;
                WHEN hoch =>
                    IF ESR = '1' THEN
                        -- anfahren nach oben
                        var_zustand := starte_hoch;
                    ELSIF conv_integer(AktPos) <= 16768 THEN 
                        -- Rolltreppe ist oben
                        var_zustand := steht;
                    END IF;
                 WHEN notfall =>
                    if Notaus = '0' and Betrieb = '1' then
                        var_zustand := steht;
                    end if; 
            END CASE;
        END IF;
        
        -- Definition des Verhaltens hisichtlich des Ausgabevektors
        case var_zustand is
            WHEN steht|notfall =>
                var_out_vec := "000";
            WHEN starte_runter|runter =>
                var_out_vec := "110";
            WHEN starte_hoch|hoch =>
                var_out_vec := "011";
        end case;
        
        -- counter solange zurücksetzen, wie etwas die Lichtschranke durchquert
        if var_zustand = steht or var_zustand = starte_runter or var_zustand = starte_hoch then
             CntClr <= '1';
        else
            CntClr <= '0';
        end if;
        
        M_Re <= var_out_vec(2);                      
        M_An <= var_out_vec(1);
        M_Li <= var_out_vec(0);
        
        if Notaus = '1' then
            LedR <= '1';
        else
            LedR <= '0';
        end if;
        
        LedG <= '1'; -- notwendige Wert-Zuweisung
        
        State(0) <= var_out_vec(0);
        State(1) <= var_out_vec(1);
        State(2) <= var_out_vec(2);
    end process;     
end BEHAVE;
