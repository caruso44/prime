import React, { useState } from 'react';
import { View, TextInput, Button, Alert, StyleSheet } from 'react-native';
import axios from 'axios';

const MyScreen = () => {
  const [number, setNumber] = useState('');
  const [inputValue, setInputValue] = useState('');

  const handleRequest = () => {
    // Faz a requisição HTTP GET
    axios
      .get(`http://yourip:8080/api/data/${number}`)
      .then((response) => {
        // Lida com a resposta da requisição
        const data = response.data;
        // Faça o que quiser com os dados retornados

        // Exemplo: exibindo um alerta com os dados retornados
        Alert.alert('Dados recebidos', JSON.stringify(data));
      })
      .catch((error) => {
        // Lida com erros da requisição
        console.error(error);
        // Exemplo: exibindo um alerta de erro
        Alert.alert('Erro', 'Ocorreu um erro na requisição.');
      });
  };

  return (
    <View style={styles.container}>
      <TextInput
          style={styles.input}
          placeholder="Digite um número"
          value={number}
          onChangeText={(text) => setNumber(text)}
          keyboardType="numeric"
        />

      <Button title="Enviar" onPress={handleRequest} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default MyScreen;