import { Alert, Button, StyleSheet, Text, TextInput, View } from "react-native";
import React, { useState } from "react";

import axios from "axios";

const MyScreen = () => {
  const [number, setNumber] = useState("");
  const [data, setData] = useState(null);

  const handleRequest = () => {
    axios
      .get(`http://yourip:8080/api/data/${number}`)
      .then((response) => {
        const data = response.data;
        setData(data);
      })
      .catch((error) => {
        console.error(error);
        Alert.alert("Error", "Nework error.");
      });
  };

  const text =
    data?.p1 && data?.p2
      ? `${data.p1} x ${data.p2} = ${data.p1 * data.p2}`
      : "No decomposition as product of two primes";

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Simple Prime Decomposition</Text>

      <View style={styles.inputContainer}>
        <Text style={styles.label}>Number to decompose</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter a number"
          value={number}
          onChangeText={(text) => setNumber(text)}
          keyboardType="numeric"
        />
      </View>

      <Button title="Send" onPress={handleRequest} style={styles.button} />

      {data && (
        <View style={styles.resultContainer}>
          <Text style={styles.resultText}>{text}</Text>
        </View>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F2F7FC",
  },
  header: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 20,
    fontFamily: "Roboto",
    color: "#3366CC",
  },
  inputContainer: {
    marginBottom: 20,
  },
  label: {
    fontSize: 16,
    marginBottom: 5,
    fontFamily: "Roboto",
    color: "#3366CC",
  },
  input: {
    width: 200,
    height: 40,
    borderWidth: 1,
    borderColor: "#3366CC",
    borderRadius: 5,
    paddingLeft: 10,
    fontFamily: "Roboto",
    color: "#000000",
    backgroundColor: "#FFFFFF",
  },
  button: {
    borderRadius: 10,
    backgroundColor: "#3366CC",
  },
  resultContainer: {
    marginTop: 20,
    borderWidth: 1,
    borderColor: "#3366CC",
    padding: 10,
    backgroundColor: "#FFFFFF",
  },
  resultText: {
    fontSize: 16,
    fontFamily: "Roboto",
    color: "#3366CC",
  },
});

export default MyScreen;
