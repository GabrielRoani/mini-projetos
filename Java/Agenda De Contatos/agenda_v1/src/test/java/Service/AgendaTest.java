package Service;

import org.example.Model.Contatos;
import org.example.Service.CadastraContato;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgendaTest {

    @Test
    public void testCadastro() {
        CadastraContato agenda = new CadastraContato();
        List<Contatos> contatosTest = agenda.cadastrarUsuario("Gabriel", "54992465552", "gabrielroani1@gmail.com");

        assertEquals(1, contatosTest.size(), "A lista de contatos deve ter 1 contato após o cadastro.");
        assertEquals("Gabriel", contatosTest.get(0).getNome(), "O nome do contato deve ser 'Gabriel'.");
        assertEquals("54992465552", contatosTest.get(0).getNumero(), "O número do contato deve ser '54992465552'.");
        assertEquals("gabrielroani1@gmail.com", contatosTest.get(0).getGmail(), "O e-mail do contato deve ser 'gabrielroani1@gmail.com'.");
    }


    @Test
    public void testListarUsuarios() {
        CadastraContato agenda = new CadastraContato();
        agenda.cadastrarUsuario("Gabriel", "11992465552", "gabrielroani1@gmail.com");
        agenda.cadastrarUsuario("Tauane", "54992465555", "tauaneroani1@gmail.com");

        List<Contatos> contatosTest = agenda.listarUsuarios();

        assertEquals(2, contatosTest.size(), "A lista de contatos deve conter 2 contatos.");
        assertTrue(contatosTest.stream().anyMatch(l -> l.getNome().equals("Gabriel") && l.getNumero().equals("11992465552") && l.getGmail().equals("gabrielroani1@gmail.com")),
                "A lista deve conter o contato 'Gabriel' com o número '11992465552' e o e-mail 'gabrielroani1@gmail.com'.");
        assertTrue(contatosTest.stream().anyMatch(l -> l.getNome().equals("Tauane") && l.getNumero().equals("54992465555") && l.getGmail().equals("tauaneroani1@gmail.com")),
                "A lista deve conter o contato 'Tauane' com o número '54992465555' e o e-mail 'tauaneroani1@gmail.com'.");
    }


    @Test
    public void testAtualizarUsuario() {
        CadastraContato agenda = new CadastraContato();
        agenda.cadastrarUsuario("Gabriel", "54992465552", "gabrielroani1@gmail.com");

        // Atualizar o contato existente
        boolean atualizado = agenda.atualizarUsuario("Gabriel", "11999999999", "novoemail@gmail.com");

        assertTrue(atualizado, "O contato 'Gabriel' deveria ser atualizado.");

        List<Contatos> contatosTest = agenda.listarUsuarios();
        assertEquals(1, contatosTest.size(), "A lista de contatos deve ter 1 contato.");
        assertEquals("11999999999", contatosTest.get(0).getNumero(), "O número do contato deve ser '11999999999'.");
        assertEquals("novoemail@gmail.com", contatosTest.get(0).getGmail(), "O e-mail do contato deve ser 'novoemail@gmail.com'.");
    }

}
